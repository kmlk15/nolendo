seq(com.github.retronym.SbtOneJar.oneJarSettings: _*)

name := "nolendo-code"

version := "1.0"

scalaVersion := "2.10.4"

resolvers ++= Seq(
  "Local Maven Repository" at "file:///"+Path.userHome+"/.m2/repository",
  "cloudera"  at "https://repository.cloudera.com/artifactory/cloudera-repos/",
  "maven" at "http://search.maven.org/",
  "jfrog" at "http://repo.jfrog.org/artifactory/libs-releases/",
  "artifactoryonline" at "http://gradle.artifactoryonline.com/gradle/libs/",
  "typesafe" at "http://repo.typesafe.com/typesafe/releases/"
)

libraryDependencies ++= Seq(
  "commons-lang" % "commons-lang" % "2.6",
  "commons-codec" % "commons-codec" % "1.8",
  "commons-io" % "commons-io" % "2.4",
  "net.databinder.dispatch" %% "dispatch-core" % "0.11.2",
  "org.slf4j" % "slf4j-log4j12" % "1.7.12",
  "com.typesafe.play" %% "play-json" % "2.2.1",
  "org.apache.httpcomponents" % "httpclient" % "4.5"
)
