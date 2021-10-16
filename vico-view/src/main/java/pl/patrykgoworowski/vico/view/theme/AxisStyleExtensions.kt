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

package pl.patrykgoworowski.vico.view.theme

import android.content.Context
import android.content.res.TypedArray
import androidx.annotation.StyleableRes
import androidx.core.content.res.use
import pl.patrykgoworowski.vico.core.Dimens
import pl.patrykgoworowski.vico.core.component.shape.LineComponent
import pl.patrykgoworowski.vico.view.R
import pl.patrykgoworowski.vico.view.extension.getColorCompat

fun TypedArray.getLineComponent(
    context: Context,
    @StyleableRes colorStyleableRes: Int,
    @StyleableRes thicknessStyleableRes: Int,
): LineComponent = use { array ->
    LineComponent(
        color = array.getColor(
            resId = colorStyleableRes,
            defaultColor = context.getColorCompat(R.color.axis_line_color),
        ),
        thicknessDp = array.getDpDimension(
            context = context,
            resId = thicknessStyleableRes,
            defaultValue = Dimens.AXIS_LINE_WIDTH,
        ),
    )
}