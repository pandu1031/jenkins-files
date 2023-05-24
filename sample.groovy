// Declarative pipeline

pipeline {
    agent any
    stages[
        stage(" Mamu file"){
            steps{
                println "Mamu has created this simple pipeline code"
            }
        }

    ]
} 
