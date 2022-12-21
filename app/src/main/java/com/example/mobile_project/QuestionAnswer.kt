package com.example.mobile_project

class QuestionAnswer {

    fun question(): Array<String> {
        var question = arrayOf (
            "What is a correct syntax to output \"Hello World\" in Kotlin?",
            "How do you insert COMMENTS in Kotlin code?",
            "Which keyword is used to declare a function?",
            "How can you create a variable with the numeric value 5?",
            "What is the output of the following code: println(5 > 3 && 5 < 10)",
            "How do you call a function in Kotlin?"
        )
       return question;
    }

    fun choices(): Array<Array<String>> {
        var choices = arrayOf(
            arrayOf("cout <<\'Hello World\';", "println(\"Hello World\")", "Console.WriteLine(\"Hello World\");", "System.out.printline(\"Hello World\")"),
            arrayOf("/* This is a comment", "// This is a comment", "-- This is a comment", "# This is a comment"),
            arrayOf("function", "define", "fun", "decl"),
            arrayOf("int num = 5", "num = 5 int", "num = 5", "val num = 5"),
            arrayOf("true", "false", "5", "3"),
            arrayOf("(myFucntion)", "myFucntion;", "myFucntion[]", "myFucntion()"),
        )
        return choices;
    }

    fun correctAnswers(): Array<String> {
        var correctAnswers = arrayOf (
            "println(\"Hello World\")",
            "// This is a comment",
            "fun",
            "val num = 5",
            "true",
            "myFucntion()"
        )
        return correctAnswers;
    }
}