package com.mayreh

package object common {
  def using[A, B](resource: A)(op: A => B)(implicit disposer: Disposer[A]): B = {
    try {
      op(resource)
    } finally {
      disposer.dispose(resource)
    }
  }
}
