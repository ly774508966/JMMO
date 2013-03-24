/*
 * Copyright (C) 2012 Tomas Shestakov. <http://code.google.com/p/jmmo/>
 */

package jmmo.grid

import org.scalatest.WordSpec
import org.scalatest.matchers.ShouldMatchers

/**
 * @author Tomas Shestakov
 */
class SingleLevelExactCacheSpec extends WordSpec with ShouldMatchers {

  override val nestedSuites = {
    List(new MTBlockingGridDataSpec(new TestGrid(10, 200, 200) with MTConcMapGridData[Dummy]
      with STImmSetGridData[Dummy]
      with MTBlockingGridData[Dummy]
      with SingleLevelExactCache[Dummy] {
      def firstLevelCacheCellSize = 10
    }))
  }

  "An SingleLevelExactCache" should {

    "fit MTBlockingGridDataSpec with AbstractGrid mixing with SingleLevelExactCache" in {}

  }

}