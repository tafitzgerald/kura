package org.eclipse.kura.lwm2m.objects;

import org.eclipse.kura.position.PositionService;
import org.eclipse.leshan.ResponseCode;
import org.eclipse.leshan.client.resource.BaseInstanceEnabler;
import org.eclipse.leshan.core.node.LwM2mResource;
import org.eclipse.leshan.core.node.Value;
import org.eclipse.leshan.core.response.ValueResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LwM2mPositionObjectDefinition extends BaseInstanceEnabler {
	private static final Logger s_logger = LoggerFactory.getLogger(LwM2mPositionObjectDefinition.class);
	
	private PositionService ps;
	
	public LwM2mPositionObjectDefinition(PositionService ps) {
		this.ps = ps;
	}
		
	@Override
    public ValueResponse read(int resourceid) {
        s_logger.info("Read on Device Resource " + resourceid);
        switch (resourceid) {
        case 0:
            return new ValueResponse(ResponseCode.CONTENT, new LwM2mResource(resourceid,
                    Value.newStringValue(String.valueOf(ps.getNmeaPosition().getLatitude()))));
        case 1:
            return new ValueResponse(ResponseCode.CONTENT, new LwM2mResource(resourceid,
                    Value.newStringValue(String.valueOf(ps.getNmeaPosition().getLongitude()))));
        case 2:
            return new ValueResponse(ResponseCode.CONTENT, new LwM2mResource(resourceid,
                    Value.newStringValue(String.valueOf(ps.getNmeaPosition().getAltitude()))));
        case 5:
            return new ValueResponse(ResponseCode.CONTENT, new LwM2mResource(resourceid,
                    Value.newStringValue(ps.getNmeaDate().substring(0, 19))));
        default:
            return super.read(resourceid);
        }
    }
}
