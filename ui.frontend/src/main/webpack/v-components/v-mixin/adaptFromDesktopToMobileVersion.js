import constant from "@util/v-constant";

export const adapt = {
    data() {
        return {
            isDesktopVersion: false,
            witchForMobileVersion:
                constant.heroBannerMiddle.widthForMobileVersion,
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
        isDesktopVersionMeth() {
            this.isDesktopVersion = window.innerWidth > this.witchForMobileVersion;
            return this.isDesktopVersion;
        }
    },
};
