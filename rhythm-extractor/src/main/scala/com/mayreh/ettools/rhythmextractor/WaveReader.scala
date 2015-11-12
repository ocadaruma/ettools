package com.mayreh.ettools.rhythmextractor

import java.io.File
import java.nio.ByteBuffer
import javax.sound.sampled.{AudioInputStream, AudioSystem}

import com.mayreh.common.using

import scala.annotation.tailrec

object WaveReader {
  /**
    * read aiff file to sequence of Short.
    * currently, supported format is [PCM_SIGNED 16 bit monoral]
    * @param file aiff file
    */
  def readAIFF(file: File): Seq[Short] = {
    val frame = Array.fill[Byte](2)(0)

    @tailrec
    def readIter(stream: AudioInputStream, available: Int, acc: Seq[Short]): Seq[Short] =
      if (available > 0) {
        val n = stream.read(frame)
        readIter(stream, available - n, ByteBuffer.wrap(frame).getShort +: acc)
      } else acc

    using(AudioSystem.getAudioInputStream(file)) { stream =>
      require(
        stream.getFormat.getFrameSize == 2 && stream.getFormat.getChannels == 1,
        "Invalid format."
      )

      readIter(stream, stream.available(), Nil).reverse
    }
  }
}
