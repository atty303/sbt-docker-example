lazy val root = (project in file("."))
    .enablePlugins(JavaAppPackaging, AshScriptPlugin, DockerPlugin)
    .settings(
      organization := "com.github.atty303",
      name := "example01-snp",
      version := "1.0.0-SNAPSHOT",
      scalaVersion := "2.11.8",
      mainClass in (Compile, run) := Some("Boot"),

      dockerBaseImage := "java:8-jdk-alpine"
    )
