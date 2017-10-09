package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * keyboardButtonRow#77608b83
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLKeyboardButtonRow() : TLObject() {
    var buttons: TLObjectVector<TLAbsKeyboardButton> = TLObjectVector()

    private val _constructor: String = "keyboardButtonRow#77608b83"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(buttons: TLObjectVector<TLAbsKeyboardButton>) : this() {
        this.buttons = buttons
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLVector(buttons)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        buttons = readTLVector<TLAbsKeyboardButton>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += buttons.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLKeyboardButtonRow) return false
        if (other === this) return true

        return buttons == other.buttons
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x77608b83.toInt()
    }
}