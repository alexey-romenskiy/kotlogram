package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * pageBlockChannel#ef1751b5
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPageBlockChannel() : TLAbsPageBlock() {
    var channel: TLAbsChat = TLChatEmpty()

    private val _constructor: String = "pageBlockChannel#ef1751b5"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(channel: TLAbsChat) : this() {
        this.channel = channel
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(channel)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        channel = readTLObject<TLAbsChat>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += channel.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPageBlockChannel) return false
        if (other === this) return true

        return channel == other.channel
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xef1751b5.toInt()
    }
}