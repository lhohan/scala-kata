
organization := "eu.lhoest"

name := "scala-kata"

version := "0.1-SNAPSHOT"

lazy val kata01 = (
  Project("kata01", file("kata01"))
  settings(
    libraryDependencies ++= Seq(
  	"org.scalatest" % "scalatest_2.10" % "2.0" % "test",
  	"org.scalacheck" %% "scalacheck" % "1.10.1"
    )
  )
)


