package com.example.fragmentdemo.demoTwo

import com.example.fragmentdemo.R

data class User(val name:String, val image:Int)

object Person{
    val listPerson= arrayListOf<User>(
        User("Deepak", R.drawable.person),
        User("Sahil", R.drawable.person),
        User("Ishita", R.drawable.person),
        User("Nandini", R.drawable.person),
        User("Mansi", R.drawable.person),
        User("Rahul", R.drawable.person),
        User("Kashish", R.drawable.person),
        User("Ramna", R.drawable.person),
        User("Trishla", R.drawable.person),
        User("Amit", R.drawable.person),
        User("Paras", R.drawable.person),
        User("Naman", R.drawable.person),
    )
}