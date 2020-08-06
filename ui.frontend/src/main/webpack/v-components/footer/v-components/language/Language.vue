<template>
    <div class="footer-language">
        <p>language side</p>
    </div>
</template>

<script>

export default {
    props: {
        languageData: Object,
        default: () => ({})
    },
    
};
</script>

<style lang="scss">
@import "./language_default";
@import "./language_media";
</style>