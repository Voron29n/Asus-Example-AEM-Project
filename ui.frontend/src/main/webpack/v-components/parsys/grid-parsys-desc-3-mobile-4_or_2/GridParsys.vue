<template>
    <div :class="[isDesktopVersion ? 'desktop-parsys' : 'mobile-parsys' ]">
        <slot></slot>
    </div>
</template>

<script>
import { adapt } from "@mixin/adaptFromDesktopToMobileVersion";

export default {
    name: "grid-parsys_desk3-mobile4-or-mobile2-data",
    components: {
        "grid-parsys_desk3-mobile4-or-mobile2-data": () => import( /* webpackChunkName: "GridParsys" */ './GridParsys.vue').then(m => m.default),
    },
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
</script>

<style lang="scss" scoped>
@import "./v-style/parsys_default";
</style>
