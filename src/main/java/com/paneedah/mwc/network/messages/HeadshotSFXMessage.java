/*
 * Modified By "https://github.com/Koud-Wind"
 * The code originates from "https://github.com/Cubed-Development/Modern-Warfare-Cubed"
 */
package com.paneedah.mwc.network.messages;

import io.netty.buffer.ByteBuf;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public final class HeadshotSFXMessage implements IMessage {

    private boolean isHeadShot;

    @Override
    public void fromBytes(final ByteBuf byteBuf) {
        this.isHeadShot = byteBuf.readBoolean();
    }

    @Override
    public void toBytes(final ByteBuf byteBuf) {
        byteBuf.writeBoolean(isHeadShot);
    }
}