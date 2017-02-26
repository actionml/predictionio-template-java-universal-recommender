import AssemblyKeys._

assemblySettings

name := "barebone-template"

organization := "io.prediction"

libraryDependencies ++= Seq(
  "org.apache.predictionio" %% "apache-predictionio-core" % "0.10.0-incubating" % "provided",
  "org.apache.spark" %% "spark-core" % "1.3.0" % "provided",
  "org.apache.spark" %% "spark-mllib" % "1.3.0" % "provided",
  "org.projectlombok" % "lombok" % "1.16.14",
  "org.scalatest" % "scalatest_2.10" % "2.2.1" % "test",
  "com.google.code.gson"    % "gson"             % "2.5",
  "com.google.guava" % "guava" % "12.0",
  "org.jblas" % "jblas" % "1.2.4"
)
