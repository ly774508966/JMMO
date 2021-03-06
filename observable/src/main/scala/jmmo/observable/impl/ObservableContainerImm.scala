package jmmo.observable.impl

import jmmo.observable.{Observable, ObservableListener}

/**
 * User: Tomas
 * Date: 31.08.13
 * Time: 19:18
 *
 * Immutable container is not a firer. It is not not required to has [[jmmo.observable.ObservableFirer.fireObservableEvent()]] method
 */
trait ObservableContainerImm[+A <: Observable] extends Observable with ChildElementsTraversable[A] {

  abstract override def addObservableListener(listener: ObservableListener) {
    super.addObservableListener(listener)
    if (listener.level >= 0) {
      addChildListener(listener)
    }
  }

  abstract override def removeObservableListener(listener: ObservableListener) {
    super.removeObservableListener(listener)
    if (listener.level >= 0) {
      removeChildListener(listener)
    }
  }

  protected def addChildListener(listener: ObservableListener) {
    addChildListenerWrapper(createChildListener(listener))
  }

  protected def removeChildListener(listener: ObservableListener) {
    removeChildListenerWrapper(createChildListener(listener))
  }

  protected def createChildListener(listener: ObservableListener): ObservableListener = ListenerWrapper(listener, this)

  protected def addChildListenerWrapper(listenerWrapper: ObservableListener) {
    childElements foreach (_.addObservableListener(listenerWrapper))
  }

  protected def removeChildListenerWrapper(listenerWrapper: ObservableListener) {
    childElements foreach (_.removeObservableListener(listenerWrapper))
  }
}
