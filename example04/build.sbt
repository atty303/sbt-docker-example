lazy val root = (project in file("."))
    .enablePlugins(sbtdocker.DockerPlugin)
    .settings(
      organization := "io.github.atty303",
      name := "example04",
      version := "1.0.0-SNAPSHOT",
      scalaVersion := "2.11.8",
      mainClass in (Compile, run) := Some("SparkPi"),
      libraryDependencies ++= Seq(
        "org.apache.spark" %% "spark-core" % "1.6.1" % "provided"),
      assemblyJarName in assembly := "example04.jar",

      dockerfile in docker := {
        new Dockerfile {
          from("gettyimages/spark:1.6.1-hadoop-2.6")
          copy(assembly.value, "/opt")
        }
      })
