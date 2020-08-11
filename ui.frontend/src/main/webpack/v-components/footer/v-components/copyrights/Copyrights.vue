<template>
    <div class="footer-copyrights">
        <p>copyrights group side</p>
    </div>
</template>

<script>

export default {
    props: {
        copyrightsData: Object,
        default: () => ({})
    },
    
};
</script>

<style lang="scss">
@import "./copyrights_default";
@import "./copyrights_media";
</style>