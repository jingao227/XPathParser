/**
  * Created by aojing on 2016/2/25.
  */
class XPath {
  def getAxis: Int = ???
  def getStep: XPath = ???
  def getPreds: XPath = ???
  def getPath: XPath = ???
  def hasq1: scala.Boolean = ???
  def isPC: scala.Boolean = ???
  def getTest: String = ???
}
case class Path(step: XPath, path: XPath) extends XPath {
  override def getStep = step
  override def getPath = path
  override def hasq1 = if (step.getPreds != null) true else false
  def q2ispath = if (path.getPath != null) true else false
  override def isPC = if (step.getAxis == 0) true else false
  override def getTest = step.getTest
}
case class Step(axis: Int, test: String, preds: XPath) extends XPath {
  override def getAxis = axis
  override def getPreds = preds
  override def hasq1 = if(preds != null) true else false
  override def isPC = if (axis == 0) true else false
  override def getTest = test
}
case class Pred(step: XPath, preds: XPath) extends XPath {
  override def getStep = step
  override def getPreds = preds
  override def hasq1 = if (step.getPreds != null) true else false
  def hasq2 = if (preds != null) true else false
  override def isPC = if (step.getAxis == 0) true else false
  override def getTest = step.getTest
}
