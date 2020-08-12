import constant from "@util/v-constant";

export const adapt = {
    data() {
        return {
            isDesktopVersion: false,
            witchForMobileVersion: constant.window.widthForMobileVersion,
        };
    },
    mounted() {
        this.adaptToWindow();
        window.addEventListener("resize", this.adaptToWindow);
    },
    beforeDestroy() {
        window.removeEventListener("resize", this.adaptToWindow);
    },
    methods: {
        adaptToWindow() {
            //default impl
            this.isDesktopVersionMeth();
        },
        isDesktopVersionMeth(maxWidth) {
            if (maxWidth !== undefined) {
                this.isDesktopVersion = window.innerWidth > maxWidth;
            } else {
                this.isDesktopVersion = window.innerWidth > this.witchForMobileVersion;
            }
            return this.isDesktopVersion;
        }
    },
};