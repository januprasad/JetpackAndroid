package com.jk.profile_layout

data class UserProfile(val name: String, val status: Boolean, val icon: String)

val userProfiles by lazy {
    mutableListOf(
        UserProfile(
            "Manju Warrier",
            status = true,
            "https://i.postimg.cc/hjG9s5jj/191245551-2889437827969196-9089566861081432824-n.jpg"
        ),
        UserProfile("Tovino Thomas", status = false, "https://i.postimg.cc/tgJtyg0k/image.png"),
        UserProfile(
            "FAFA",
            status = false,
            "https://i.pinimg.com/736x/93/fd/78/93fd783ebf3476b29653e603ed35b960.jpg"
        ),
        UserProfile(
            "Nazriya",
            status = true,
            "https://i.pinimg.com/736x/6d/a3/aa/6da3aacc1306fd8a7cf2d08b1ba02894.jpg"
        ),
        UserProfile(
            "Sruthi",
            status = true,
            "https://i.pinimg.com/originals/11/6a/6f/116a6f11d8ea8ea602519b3d27fc6958.jpg"
        ),
        UserProfile(
            "Joju G",
            status = false,
            "https://www.nowrunning.com/content/Artist/JojuGeorge/banner.jpg"
        ),
        UserProfile(
            "Chaokochan",
            status = false,
            "https://upload.wikimedia.org/wikipedia/en/1/12/Kunchackoboban002.jpg"
        )
    )
}
