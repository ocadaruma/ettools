package com.mayreh.common

import java.io.Closeable

trait Disposer[-A] {
  def dispose(resource: A): Unit
}

object Disposer {
  implicit val closeableDisposer: Disposer[Closeable] = new Disposer[Closeable] {
    def dispose(resource: Closeable) = resource.close()
  }

  implicit val autoCloseableDisposer: Disposer[AutoCloseable] = new Disposer[AutoCloseable] {
    def dispose(resource: AutoCloseable) = resource.close()
  }
}
