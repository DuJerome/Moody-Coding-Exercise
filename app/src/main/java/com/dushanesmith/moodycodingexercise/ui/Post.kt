package com.dushanesmith.moodycodingexercise.ui.theme

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.dushanesmith.moodycodingexercise.data.model.Card
import com.dushanesmith.moodycodingexercise.ui.theme.util.dimens.mediumPadding1
import com.dushanesmith.moodycodingexercise.ui.theme.util.dimens.smallPadding2

/*
Here is a modular Post composable that accommodates all different types of post by conditional
composition
 */
@Composable
fun Post(card: Card?, context: Context) {
    if (card?.card_type == "text") {
        Column(
            Modifier
                .padding(mediumPadding1)
                .wrapContentHeight()
                .fillMaxWidth()
                .background(WhiteSmoke)
                .clip(RoundedCornerShape(smallPadding2)),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = card.card.value,
                fontWeight = FontWeight(800),
                fontSize = card.card.attributes.font.size.sp,
                color = Color(card.card.attributes.text_color.toColorInt())

            )
        }
    } else if (card?.card_type == "title_description") {
        Column(
            Modifier
                .padding(mediumPadding1)
                .wrapContentHeight()
                .fillMaxWidth()
                .background(WhiteSmoke)
                .clip(RoundedCornerShape(smallPadding2)),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = card.card.title.value,
                fontWeight = FontWeight(600),
                fontSize = card.card.title.attributes.font.size.sp,
                color = Color(card.card.title.attributes.text_color.toColorInt()),
                modifier = Modifier.padding(smallPadding2)
            )
            Text(
                text = card.card.description.value,
                fontSize = card.card.description.attributes.font.size.sp,
                color = Color(card.card.description.attributes.text_color.toColorInt()),
                modifier = Modifier.padding(smallPadding2)
            )
        }
    } else if (card?.card_type == "image_title_description") {
        //dynamically setting the height to a fraction of the original
        val height =
            if (context.resources.configuration.orientation == 1) (card.card.image.size.height * .4).dp else (card.card.image.size.height * .7).dp
        val width =
            if (context.resources.configuration.orientation == 1) (card.card.image.size.width * .4).dp else (card.card.image.size.width * .7).dp

        //Box because it allows for a overlap of content
        Box(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(smallPadding2)
                .clip(RoundedCornerShape(smallPadding2)),
            contentAlignment = Alignment.BottomStart
        ) {
            AsyncImage(
                model = ImageRequest.Builder(context = context)
                    .data(card.card.image.url).build(),
                modifier = Modifier
                    .height(height)
                    .width(width),
                contentScale = ContentScale.Crop,
                contentDescription = null,
            )
            Column(
                modifier = Modifier
                    .padding(
                        smallPadding2
                    )
                    .padding(mediumPadding1),
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = card.card.title.value,
                    fontSize = card.card.title.attributes.font.size.sp,
                    color = Color(card.card.title.attributes.text_color.toColorInt())
                )
                Text(
                    text = card.card.description.value,
                    fontSize = card.card.description.attributes.font.size.sp,
                    color = Color(card.card.description.attributes.text_color.toColorInt())
                )
            }
        }

    }
}