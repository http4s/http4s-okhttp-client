ThisBuild / tlBaseVersion := "0.23"
ThisBuild / tlMimaPreviousVersions ++= (0 to 11).map(y => s"0.23.$y").toSet
ThisBuild / developers := List(
  tlGitHubDev("rossabaker", "Ross A. Baker")
)

val Scala213 = "2.13.8"
ThisBuild / crossScalaVersions := Seq("2.12.16", Scala213, "3.1.2")
ThisBuild / scalaVersion := Scala213

lazy val root = project.in(file(".")).aggregate(okHttpClient).enablePlugins(NoPublishPlugin)

val http4sVersion = "0.23.12"
val okhttpVersion = "4.9.3"
val okioVersion = "2.10.0"

ThisBuild / resolvers +=
  "s01 snapshots".at("https://s01.oss.sonatype.org/content/repositories/snapshots/")

lazy val okHttpClient = project
  .in(file("okhttp-client"))
  .settings(
    name := "http4s-okhttp-client",
    description := "okhttp implementation for http4s clients",
    startYear := Some(2018),
    libraryDependencies ++= Seq(
      "org.http4s" %% "http4s-client" % http4sVersion,
      "com.squareup.okhttp3" % "okhttp" % okhttpVersion,
      "com.squareup.okio" % "okio" % okioVersion,
      "org.http4s" %% "http4s-client-testkit" % "0.23.12" % Test,
    ),
  )
