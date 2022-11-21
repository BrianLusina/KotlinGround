package com.kotlinground.design.behavioralpatterns.iterator

data class Profile(val profileId: String)

// The collection interface must declare a factory method for
// producing iterators. You can declare several methods if there
// are different kinds of iteration available in your program.
interface SocialNetwork {
    fun createFriendsIterator(profileId: String): Iterator<Profile>
    fun createCoworkersIterator(profileId: String): Iterator<Profile>
}

// Each concrete collection is coupled to a set of concrete
// iterator classes it returns. But the client isn't, since the
// signature of these methods returns iterator interfaces.
class Facebook : SocialNetwork {
    override fun createFriendsIterator(profileId: String): Iterator<Profile> {
        TODO("Not yet implemented")
    }

    override fun createCoworkersIterator(profileId: String): Iterator<Profile> {
        TODO("Not yet implemented")
    }
}

class FacebookIterator : Iterator<Profile> {
    override fun hasNext(): Boolean {
        TODO("Not yet implemented")
    }

    override fun next(): Profile {
        TODO("Not yet implemented")
    }
}
