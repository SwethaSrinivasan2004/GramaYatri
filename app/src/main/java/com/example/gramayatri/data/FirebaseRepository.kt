package com.example.gramayatri.data

import com.example.gramayatri.models.ActivityItem
import com.google.firebase.database.*

object FirebaseRepository {

    private val database =
        FirebaseDatabase
            .getInstance(
                "https://gramayatri-bb560-default-rtdb.asia-southeast1.firebasedatabase.app/"
            )
            .reference

    // ---------------- SEND ACTIVITY ----------------

    fun sendActivity(

        user: String,

        message: String,

        type: String
    ) {

        val activityId =

            database
                .child("activities")
                .push()
                .key

        if (activityId != null) {

            val activity = ActivityItem(

                user = user,

                message = message,

                type = type,

                timestamp =
                    System.currentTimeMillis()
            )

            database
                .child("activities")
                .child(activityId)
                .setValue(activity)
        }
    }

    // ---------------- LISTEN FOR ACTIVITIES ----------------

    fun listenForActivities(

        onUpdate:
            (List<ActivityItem>) -> Unit
    ) {

        database
            .child("activities")

            .addValueEventListener(

                object : ValueEventListener {

                    override fun onDataChange(

                        snapshot: DataSnapshot
                    ) {

                        val list =
                            mutableListOf<ActivityItem>()

                        for (child in snapshot.children) {

                            val item =
                                child.getValue(
                                    ActivityItem::class.java
                                )

                            if (item != null) {

                                list.add(item)
                            }
                        }

                        onUpdate(
                            list.reversed()
                        )
                    }

                    override fun onCancelled(
                        error: DatabaseError
                    ) {
                    }
                }
            )
    }
}