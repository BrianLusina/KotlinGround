package com.kotlinground.datastructures.trees

import com.kotlinground.datastructures.linkedlists.generateKey

interface TreeNode<T> {
    var data: T
    val key: String?
        get() = lazy { generateKey(data) }
            .toString()
}
