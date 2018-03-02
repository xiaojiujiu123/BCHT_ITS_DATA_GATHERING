package com.bcht.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class Body {
	@XStreamAlias("veh")
  	private Veh veh;

	public Veh getVeh() {
		return veh;
	}

	public void setVeh(Veh veh) {
		this.veh = veh;
	}
}
