import sbt._

class MyProject(info: ProjectInfo) extends DefaultProject(info){
//  val java_net = "java.net" at "http://download.java.net/maven/2/"
  val scalaTest = "org.scalatest" % "scalatest" % "1.2"
  val mockit    = "org.mockito" % "mockito-core" % "1.8.1" % "test"
}

