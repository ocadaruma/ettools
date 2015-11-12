package com.mayreh.ettools.rhythmextractor

import scala.annotation.tailrec

case class Config(volumeIncreaseRate: Double)
object Config {
  val defaultConfig = Config(volumeIncreaseRate = 0.5)
}

case class RhythmExtractor(config: Config = Config.defaultConfig) {
  def extract(frames: Seq[Short]): Seq[Int] = {
//    @tailrec
//    def extractIter(previousValue: Short,
//                    index: Int,
//                    source: Seq[Short],
//                    result: Seq[Int]): Seq[Int] = source match {
//      case head +: tail =>
//        val p = previousValue.abs.toDouble / Short.MaxValue
//        val c = head.abs.toDouble / Short.MaxValue
//
//        if (c - p > config.volumeIncreaseRate) {
//          extractIter(previousValue, index + 1, tail, index +: result)
//        } else {
//          extractIter(head, index + 1, tail, result)
//        }
//
//      case _ => result
//    }
//
//    extractIter(0, 0, frames, Nil).reverse

    ???
  }
}

