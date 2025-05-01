package com.example.posts.app.domain.model

data class Post(
    val posts: List<PostsResponse> = listOf(),
    val total: Int = 0, // 251
    val skip: Int = 0, // 0
    val limit: Int = 0 // 30
)

data class PostsResponse(
    val id: Int = 0, // 1
    val title: String = "", // His mother had always taught him
    val body: String = "", // His mother had always taught him not to ever think of himself as better than others. He'd tried to live by this motto. He never looked down on those who were less fortunate or who had less money than him. But the stupidity of the group of people he was talking to made him change his mind.
    val tags: List<String> = listOf(),
    val reactions: Reactions = Reactions(),
    val views: Int = 0, // 305
    val userId: Int = 0 // 121
)

data class Reactions(
    val likes: Int = 0, // 192
    val dislikes: Int = 0 // 25
)