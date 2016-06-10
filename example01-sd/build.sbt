lazy val root = (project in file("."))
    .enablePlugins(JavaAppPackaging, AshScriptPlugin, sbtdocker.DockerPlugin)
    .settings(
      organization := "io.github.atty303",
      name := "example01-sd",
      version := "1.0.0-SNAPSHOT",
      scalaVersion := "2.11.8",
      mainClass in (Compile, run) := Some("Boot"),

      dockerfile in docker := {
        val stageDir: File = stage.value
        val targetDir = "/opt/docker"

        new Dockerfile {
          from("java:8-jdk-alpine")
          copy(stageDir, targetDir)
          entryPoint(s"$targetDir/bin/${executableScriptName.value}")
        }
      })
