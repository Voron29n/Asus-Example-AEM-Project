<template>
    <div>
        <slot v-if="isDesktopVersion" name="desktop"></slot>
        <slot v-else name="mobile"></slot>
    </div>
</template>

<script>
import { adapt } from "@mixin/adaptFromDesktopToMobileVersion";

export default {
    mixins: [adapt],
};
</script>

<style lang="scss">
@import "./v-style/banner_default";
@import "./v-style/banner_media";
</style>
