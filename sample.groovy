// Declarative pipeline

pipeline {
    agent any
    stages[
        stage(" pandu file"){
            steps{
                println "this is simple pipeline code"
            }
        }

    ]

}
