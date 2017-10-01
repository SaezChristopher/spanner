package lt.neworld.spanner

import android.support.annotation.RequiresApi
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextUtils

/**
 * @author Andrius Semionovas
 * @since 2017-08-01
 */
class Spanner(text: CharSequence?) : SpannableStringBuilder(text) {
    constructor() : this("")

    override fun append(text: CharSequence?): Spanner {
        text ?: return this

        super.append(text)

        return this
    }

    override fun append(text: CharSequence, start: Int, end: Int): Spanner {
        super.append(text, start, end)

        return this
    }

    override fun append(text: Char): Spanner {
        super.append(text)

        return this
    }

    override fun insert(where: Int, text: CharSequence?): Spanner {
        text ?: return this

        super.insert(where, text)

        return this
    }

    @RequiresApi(api = 21)
    override fun append(text: CharSequence?, what: Any?, flags: Int): Spanner {
        text ?: return this

        super.append(text, what, flags)

        return this
    }

    override fun replace(start: Int, end: Int, replace: CharSequence?): Spanner {
        replace ?: return this

        super.replace(start, end, replace)

        return this
    }

    override fun replace(start: Int, end: Int, replace: CharSequence?, tbstart: Int, tbend: Int): Spanner {
        replace ?: return this

        super.replace(start, end, replace, tbstart, tbend)

        return this
    }

    override fun delete(start: Int, end: Int): Spanner {
        super.delete(start, end)

        return this
    }

    fun append(text: CharSequence?, vararg spans: Any): Spanner {
        text ?: return this

        val start = length

        append(text)

        setSpans(start, length, *spans)

        return this
    }

    fun insert(where: Int, text: CharSequence, vararg spans: Any): Spanner {
        super.insert(where, text)

        setSpans(where, where + text.length, *spans)

        return this
    }

    fun replace(start: Int, end: Int, text: CharSequence?, vararg spans: Any): Spanner {
        val text = text ?: ""

        super.replace(start, end, text)

        setSpans(start, start + text.length, *spans)

        return this
    }

    fun replace(search: CharSequence, replace: CharSequence, vararg spans: Any): Spanner {
        val start = TextUtils.indexOf(this, search)

        if (start < 0) {
            return this
        }

        val end = start + search.length

        return replace(start, end, replace, *spans)
    }

    fun setSpans(start: Int, end: Int, vararg spans: Any): Spanner {
        for (span in spans) {
            setSpan(span, start, end, 0)
        }
        return this
    }
}
