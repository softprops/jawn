package jawn
package support.rojoma

import scala.collection.mutable
import com.rojoma.json.ast._

object Parser extends SupportParser[JValue] {
  implicit val facade: Facade[JValue] =
    new MutableFacade[JValue] {
      def jnull() = JNull
      def jfalse() = JBoolean(false)
      def jtrue() = JBoolean(true)
      def jnum(s: String) = JNumber(BigDecimal(s))
      def jint(s: String) = JNumber(BigDecimal(s))
      def jstring(s: String) = JString(s)
      def jarray(vs: mutable.ArrayBuffer[JValue]) = JArray(vs)
      def jobject(vs: mutable.Map[String, JValue]) = JObject(vs)
    }
}
