package com.example.bettingstrategies.model

import android.content.Context
import java.io.*
import java.lang.Exception

class FileManager(private val context: Context) {

    fun readFile(filename: String): Any? {
        return try {
            val objectInputStream = ObjectInputStream(FileInputStream(
                context.filesDir.path + "/" + filename
            ))
            objectInputStream.readObject()
        } catch (e: Exception) {
            null
        }
    }

    fun writeFile(filename: String, file: Any) {
        val objectOutputStream = ObjectOutputStream(FileOutputStream(
            context.filesDir.path + "/" + filename
        ))
        objectOutputStream.writeObject(file)
    }
}