package ru.ifmo.rain.adsl.xmlconverter

import ru.ifmo.rain.adsl.Context

class KotlinWriter {
    private var depth = 0
    val buffer = StringBuffer()
    val ctx = Context(buffer)

    public fun handleAttribute(parentName: String, name: String, value:String) {

    }

    public fun handleElement(name: String) {

    }

    public fun toString(): String {
        return buffer.toString()
    }

//    private void writeHeader() {
//        ctx writeln "package com.example.android_test"
//    }

}

