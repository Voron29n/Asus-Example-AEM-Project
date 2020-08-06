<template>
    <div class="footer-links_group">
        <p>links group side</p>
    </div>
</template>

<script>

export default {
    props: {
        linksGroupData: Object,
        default: () => ({})
    },
    
};
</script>

<style lang="scss">
@import "./links_group_default";
@import "./links_group_media";
</style>