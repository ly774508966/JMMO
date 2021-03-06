package jmmo.property

/**
 * User: Tomas
 * Date: 04.09.13
 * Time: 13:23
 *
 * A Property which updates it value and fire ChangedValueEvent in spite of new value equals old one
 */
class PropertyAlways[A](name: String = "", value: A = jmmo.util.sysDefault[A]) extends PropertyImpl(name, value) with UpdateAlways [A]

object PropertyAlways {

  def apply[A](name: String = "", value: A = jmmo.util.sysDefault[A]) = new PropertyAlways[A](name, value)
}
