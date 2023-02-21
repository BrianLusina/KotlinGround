package com.kotlinground.datastructures.crdt.cvrdt

import kotlinx.datetime.Clock


fun <T> mergeableValueOf(value: T) = MergeableValue(value, Clock.System.now())