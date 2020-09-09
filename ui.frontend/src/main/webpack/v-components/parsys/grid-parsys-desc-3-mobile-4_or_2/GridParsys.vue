<template>
    <div :class="[isDesktopVersion ? 'desktop-parsys' : 'mobile-parsys' ]">
        <slot></slot>
    </div>
</template>

<script>
import { adapt } from "@mixin/adaptFromDesktopToMobileVersion";

export default {
    mixins: [adapt],
    props: {
        numberParsysMobileVersion: {
            type: String,
            required: true,
        },
        numberParsysDesktopVersion: {
            type: String,
            required: true,
        },
    },
    methods: {
        adaptToWindow() {
            let arrayWithParsysElements = Array.from(
                this.$el.querySelectorAll(".parsys-block")
            );

            let numberParsysDesktopVersion = parseInt(
                this.$props.numberParsysDesktopVersion
            );
            let numberParsysMobileVersion = parseInt(
                this.$props.numberParsysMobileVersion
            );
            let isDesktopVersion = this.isDesktopVersionMeth();

            arrayWithParsysElements.forEach(function (value, index) {
                if (isDesktopVersion) {
                    value.style.display =
                        index >= numberParsysDesktopVersion ? "none" : "block";
                } else {
                    value.style.display =
                        index >= numberParsysMobileVersion ? "none" : "block";
                }
            });
        },
    },
};

import (/* webpackChunkName: "GridParsys" */ './v-style/_parsys_default.scss');
</script>
