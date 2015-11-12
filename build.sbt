lazy val commonSettings = Seq(
  scalaVersion := "2.11.7",
  scalacOptions += "-deprecation",
  libraryDependencies ++= Seq(
    "org.scalatest" %% "scalatest" % "2.2.5" % "test"
  )
)

lazy val common = project.in(file("common"))
  .settings(commonSettings: _*)

lazy val rhythmExtractor = project.in(file("rhythm-extractor"))
  .settings(commonSettings: _*)
  .dependsOn(common)
