import constant from "@util/v-constant";

export const adapt = {
    data() {
        return {
            isDesktopVersion: false,
            witchForMobileVersion: constant.window.widthForMobileVersion,
            constWindowVersion: {
                small: constant.window.widthForSmallVersion,
                medium: constant.window.widthForMediumVersion,
            },
            windowVersion: null,
            currentWidth: null,
        };
    },
    mounted() {
        this.currentWidth = window.innerWidth;
        this.adaptToWindow();
        this.getWindowVersion();
        window.addEventListener("resize", this.adaptToWindow);
    },
    beforeDestroy() {
        window.removeEventListener("resize", this.adaptToWindow);
    },
    methods: {
        adaptToWindow() {
            //default impl
            this.isDesktopVersionMeth();
            this.getWindowVersion();
        },
        isDesktopVersionMeth(maxWidth) {
            if (maxWidth !== undefined) {
                this.isDesktopVersion = window.innerWidth > maxWidth;
            } else {
                this.isDesktopVersion = window.innerWidth > this.witchForMobileVersion;
            }
            return this.isDesktopVersion;
        },
        getWindowVersion() {
            this.currentWidth = window.innerWidth;
            if (this.$data.currentWidth <= this.constWindowVersion.small) {
                return (this.windowVersion = "small");
            } else if (
                this.$data.currentWidth > this.constWindowVersion.small &&
                this.$data.currentWidth <= this.constWindowVersion.medium
            ) {
                return (this.windowVersion = "medium");
            } else if (this.$data.currentWidth > this.constWindowVersion.medium) {
                return (this.windowVersion = "large");
            }
        },
    },
};