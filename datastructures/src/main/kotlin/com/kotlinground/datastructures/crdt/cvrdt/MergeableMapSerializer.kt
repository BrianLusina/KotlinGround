package com.kotlinground.datastructures.crdt.cvrdt

import kotlinx.collections.immutable.toPersistentMap
import kotlinx.datetime.Instant
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

class MergeableMapSerializer<K, V>(keySerializer: KSerializer<K>, valueSerializer: KSerializer<V>) :
    KSerializer<MergeableMap<K, V>> {

//    private val mapSerializer = MapSerializer(keySerializer, MergeableValue(valueSerializer))
    private val tombstoneSerializer = MapSerializer(keySerializer, Instant.serializer())

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("mergeableMap") {
//        element("map", descriptor = mapSerializer.descriptor)
        element("tombstones", descriptor = tombstoneSerializer.descriptor)
    }

    override fun deserialize(decoder: Decoder): MergeableMap<K, V> = decoder.decodeStructure(descriptor) {
        var map = mapOf<K, MergeableValue<V>>()
        var tombstones = mapOf<K, Instant>()

        while (true) {
            when (val index = decodeElementIndex(descriptor)) {
//                0 -> map = decodeSerializableElement(descriptor, index, mapSerializer)
                1 -> tombstones = decodeSerializableElement(descriptor, index, tombstoneSerializer)
                CompositeDecoder.DECODE_DONE -> break
            }
        }
        MergeableMap(map.toPersistentMap(), tombstones.toPersistentMap())
    }

    override fun serialize(encoder: Encoder, value: MergeableMap<K, V>) {
        encoder.encodeStructure(descriptor) {
//            encodeSerializableElement(descriptor, 0, mapSerializer, value.map)
            encodeSerializableElement(descriptor, 0, tombstoneSerializer, value.tombstones)
        }
    }
}
