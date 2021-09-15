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

package pl.patrykgoworowski.vico.compose.dataset.bar

import android.graphics.Paint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import pl.patrykgoworowski.vico.compose.extension.pixels
import pl.patrykgoworowski.vico.core.component.Component
import pl.patrykgoworowski.vico.core.component.shape.shader.DynamicShader
import pl.patrykgoworowski.vico.core.dataset.line.LineDataSet

@Composable
fun lineDataSet(
    point: Component? = null,
    pointSize: Dp = 6.dp,
    spacing: Dp = 16.dp,
    lineWidth: Dp = 2.dp,
    lineColor: Color = Color.LightGray,
    lineBackgroundShader: DynamicShader? = null,
    lineStrokeCap: StrokeCap = StrokeCap.Round,
    cubicStrength: Float = 1f,
    minX: Float? = null,
    maxX: Float? = null,
    minY: Float? = null,
    maxY: Float? = null,
): LineDataSet {
    val dataSet = remember { LineDataSet() }
    return dataSet.apply {
        this.point = point
        this.pointSize = pointSize.pixels
        this.spacing = spacing.pixels
        this.lineWidth = lineWidth.pixels
        this.lineColor = lineColor.toArgb()
        this.lineBackgroundShader = lineBackgroundShader
        this.lineStrokeCap = lineStrokeCap.paintCap
        this.cubicStrength = cubicStrength
        this.minX = minX
        this.maxX = maxX
        this.minY = minY
        this.maxY = maxY
    }
}

private val StrokeCap.paintCap: Paint.Cap
    get() = when (this) {
        StrokeCap.Butt -> Paint.Cap.BUTT
        StrokeCap.Round -> Paint.Cap.ROUND
        StrokeCap.Square -> Paint.Cap.SQUARE
        else -> throw IllegalArgumentException("Not `StrokeCap.Butt`, `StrokeCap.Round`, or `StrokeCap.Square`.")
    }