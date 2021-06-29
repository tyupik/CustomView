package ru.netology.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PointF
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.core.content.withStyledAttributes
import ru.netology.customview.utils.AndroidUtils
import kotlin.math.min
import kotlin.random.Random

class StatsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private var lineWidth = AndroidUtils.dp(context, 25F)
    private var center = PointF(0F, 0F)
    private var radius = 0F

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = lineWidth.toFloat()
        strokeCap = Paint.Cap.ROUND
        strokeJoin = Paint.Join.ROUND
    }

    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        textAlign = Paint.Align.CENTER
    }

    private var oval = RectF(0F, 0F, 0F, 0F)

    var data: List<Float> = emptyList()
        set(value) {
            field = value
            invalidate()
        }

//    private val dataCalc = getValues(data)
//    private val dataCalc = data


    private var colors = emptyList<Int>()

    init {
        context.withStyledAttributes(attrs, R.styleable.StatsView) {
            textPaint.textSize = getDimension(
                R.styleable.StatsView_textSize,
                AndroidUtils.dp(context, 40F).toFloat()
            )
            lineWidth = getDimensionPixelSize(
                R.styleable.StatsView_lineWidth,
                AndroidUtils.dp(context, 25F)
            )
            paint.strokeWidth = lineWidth.toFloat()
            colors = listOf(
                getColor(R.styleable.StatsView_color1, getRandomColor()),
                getColor(R.styleable.StatsView_color2, getRandomColor()),
                getColor(R.styleable.StatsView_color3, getRandomColor()),
                getColor(R.styleable.StatsView_color4, getRandomColor())
            )
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        center = PointF(w / 2F, h / 2F)
        radius = min(w, h) / 2F - lineWidth / 2F
        oval = RectF(
            center.x - radius,
            center.y - radius,
            center.x + radius,
            center.y + radius
        )
    }

    override fun onDraw(canvas: Canvas) {
        val dataCalc = getValues(data)

        if (dataCalc.isEmpty()) {
            return
        }
        var startAngle = -90F
        dataCalc.forEachIndexed() { index, item ->
            val angle = item * 360F
            paint.color = colors.getOrElse(index) { getRandomColor() }
            canvas.drawArc(oval, startAngle, angle, false, paint)
            startAngle += angle
        }

        if (dataCalc[0] > 0) {
            paint.color = colors.getOrElse(0) { getRandomColor() }
            startAngle = -90F
            canvas.drawArc(oval, startAngle, -0.001F, false, paint)
        }

        canvas.drawText(
            "%.2f%%".format(dataCalc.sum() * 100F),
            center.x,
            center.y + textPaint.textSize / 4,
            textPaint
        )
    }

    private fun getRandomColor() = Random.nextInt(0xFF000000.toInt(), 0xFFFFFFFF.toInt())

    /*
    Считаем, что сумма всех входящих данных равна 100%, т.к. коэффициент, на который
    увеличиваются все входные значения, неизвестен. Т.е. даже если придет одно значение, то
    окружность будет ПОЛНОСТЬЮ закрашена одной дугой, если два значения - окружность поделится
    на две дуги длинами пропорциональными их числовым значениям
    */
    private fun getValues(data: List<Float>): List<Float> {
        val sum = data.sum()

        var dataFloat = emptyArray<Float>()
        for (i in data.indices) {
            dataFloat += data[i] / sum
        }
        return dataFloat.toList()
    }
}

