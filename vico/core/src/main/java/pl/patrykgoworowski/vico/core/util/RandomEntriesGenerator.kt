/*
 * Copyright (c) 2021. Patryk Goworowski
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pl.patrykgoworowski.vico.core.util

import pl.patrykgoworowski.vico.core.chart.composed.ComposedChartEntryModel
import pl.patrykgoworowski.vico.core.entry.ChartEntryModel
import pl.patrykgoworowski.vico.core.entry.ChartEntryModelProducer
import pl.patrykgoworowski.vico.core.entry.FloatEntry
import pl.patrykgoworowski.vico.core.entry.composed.ComposedChartEntryModelProducer
import pl.patrykgoworowski.vico.core.entry.entryOf

public class RandomEntriesGenerator(
    private val xRange: IntRange = 0..X_RANGE_TOP,
    private val yRange: IntRange = 0..Y_RANGE_TOP
) {
    public fun generateRandomEntries(): List<FloatEntry> {
        val result = ArrayList<FloatEntry>()
        val yLength = yRange.last - yRange.first
        for (x in xRange) {
            result += entryOf(x.toFloat(), (Math.random() * yLength).toFloat())
        }
        return result
    }

    public fun randomEntryModel(): ChartEntryModel =
        ChartEntryModelProducer(generateRandomEntries()).model

    public fun randomComposedEntryModel(): ComposedChartEntryModel<ChartEntryModel> =
        ComposedChartEntryModelProducer(
            ChartEntryModelProducer(generateRandomEntries()),
            ChartEntryModelProducer(generateRandomEntries()),
            ChartEntryModelProducer(generateRandomEntries()),
        ).model

    private companion object {
        const val X_RANGE_TOP = 10
        const val Y_RANGE_TOP = 20
    }
}
