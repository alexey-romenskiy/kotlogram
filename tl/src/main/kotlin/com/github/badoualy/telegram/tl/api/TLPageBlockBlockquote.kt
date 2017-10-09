package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * pageBlockBlockquote#263d7c26
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPageBlockBlockquote() : TLAbsPageBlock() {
    var text: TLAbsRichText = TLTextEmpty()

    var caption: TLAbsRichText = TLTextEmpty()

    private val _constructor: String = "pageBlockBlockquote#263d7c26"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(text: TLAbsRichText, caption: TLAbsRichText) : this() {
        this.text = text
        this.caption = caption
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(text)
        writeTLObject(caption)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        text = readTLObject<TLAbsRichText>()
        caption = readTLObject<TLAbsRichText>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += text.computeSerializedSize()
        size += caption.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPageBlockBlockquote) return false
        if (other === this) return true

        return text == other.text
                && caption == other.caption
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x263d7c26.toInt()
    }
}