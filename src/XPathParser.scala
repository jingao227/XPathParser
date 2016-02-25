
import scala.util.parsing.combinator.{RegexParsers, JavaTokenParsers}

/**
  * Created by aojing on 2016/2/25.
  */
class XPathParser extends RegexParsers{
  val ident: Parser[String] = """[a-zA-Z_]\w*""".r
  def path: Parser[XPath] = (step~opt(path)) ^^ {
    case a ~ None => Path(a, null)
    case a ~ Some(b) => Path(a, b)
  }
  def step: Parser[XPath] = ("/"~ident~opt(preds)) ^^ {
    case ("/" ~ a ~ None) => Step(0, a, null)
    case ("/" ~ a ~ Some(b)) => Step(0, a, b)
  } | ("//"~ident~opt(preds)) ^^ {
    case ("//" ~ a ~ None) => Step(1, a, null)
    case ("//" ~ a ~ Some(b)) => Step(1, a, b)
  }
  def preds: Parser[XPath] = ("["~step~"]"~opt(preds)) ^^ {
    case ("[" ~ a ~ "]" ~ None) => Pred(a, null)
    case ("[" ~ a ~ "]" ~ Some(b)) => Pred(a, b)
  }
  def apply(input: String): XPath = parseAll(path, input) match {
    case Success(result, _) => result
    case failure : NoSuccess => scala.sys.error(failure.msg)
  }
//  def expr: Parser[Any] = term~rep("+"~term | "-"~term)
//  def term: Parser[Any] = factor~rep("*"~factor | "/"~factor)
//  def factor: Parser[Any] = floatingPointNumber | "("~expr~")"
}
