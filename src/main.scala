import java.io.FileReader

/**
  * Created by aojing on 2016/2/25.
  */
object main extends XPathParser {
  def main(args:Array[String]): Unit = {
    val input = "//BOOKS/ITEM[//TITLE][/ISBN]//AUTHOR"//new FileReader("XPath.txt")  //"ad::A//[pc::C]pc::B[ad::D]"//"2*(3+7)"//
//    println(parseAll(path, input))
    val p: XPath = apply(input)
    println(p.getPath.getPath.getTest)
  }
}
